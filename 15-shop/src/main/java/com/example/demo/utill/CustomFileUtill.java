package com.example.demo.utill;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;

@Component
@RequiredArgsConstructor
@Log4j2
public class CustomFileUtill {

	@Value("${com.example.demo.upload.path}")	//lombook아님
	private String uploadPath;
	
	@PostConstruct	//초기값 설정 가능하게 해준다 bean은 초기화 안되고 한번만 포기화 하게끔 해준다.
	public void init() {
		File tempFolder = new File(uploadPath);
		
		if(!tempFolder.exists()) {
			tempFolder.mkdir();
		}
		
		uploadPath = tempFolder.getAbsolutePath();
		log.info("=======================");
		log.info(uploadPath);
	}

	public List<String> saveFiles(List<MultipartFile> files) {
		
		//files가 없으면?
		if(files == null || files.size() == 0) {
			return null;
		}
		
		List<String> uploadNmaes = new ArrayList<>();
		for(MultipartFile multipartFile : files) {
			
			//uuid와 _파일이름 으로 이름 정한다.
			String saveName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
			
			Path savePath = Paths.get(uploadPath,saveName);
			
			try {
				Files.copy(multipartFile.getInputStream(), savePath);
				
				//파일의 타입을 가져온다.
				String contentType = multipartFile.getContentType();
				
				//썸네일 경로 지정
				if(contentType != null && contentType.startsWith("image")) {
					Path thumbnailPath = Paths.get(uploadPath,"s_"+saveName);
					
					//썸네일 저장 설정
					Thumbnails.of(savePath.toFile())
						.size(400,400)
						.outputFormat("png")
						.toFile(thumbnailPath.toFile());
				}
				
				uploadNmaes.add(saveName);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return uploadNmaes;
	}
	
	//파일명을 입력했을떄 화면에 파일이 나오게
	public ResponseEntity<Resource> getFile(String fileName){
		
		Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
		
		//없는 파일이라면?
		if(!resource.exists()) {
			//디폴트 이미지 생성
			resource = new FileSystemResource(uploadPath + File.separator + "default.png");
		}
		
		HttpHeaders headers = new HttpHeaders();
		
		try {			
			headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return ResponseEntity.ok().headers(headers).body(resource);
	}
	
	//파일 삭제
	public void deleteFiles(List<String> fileNames) {
		if(fileNames == null || fileNames.size() == 0) {
			return;
		}
		
		fileNames.forEach(
				fileName -> {
					String thumbnailFileName =	"s_"+fileName;
					Path thumbnailPath = Paths.get(uploadPath,thumbnailFileName);
					Path filePath = Paths.get(uploadPath,fileName);
					
					try {
						Files.deleteIfExists(filePath);
						Files.deleteIfExists(thumbnailPath);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
	}

}








