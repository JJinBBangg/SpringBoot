package com.example.demo.controller;

import java.io.*;
import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

import jakarta.servlet.annotation.*;

@Controller
@RequestMapping("sub29")
//@MultipartConfig(fileSizeThreshold = 256,location = "/",maxFileSize = 3000,maxRequestSize = 234235)
public class Controller29 {

	@Autowired
	private Mapper08 mapper;

	@GetMapping("link1")
	public void method1() {

	}

	@PostMapping("link2")
	public void method2(@RequestParam("myFile") MultipartFile myFile) {
		System.out.println(myFile.getOriginalFilename());
		System.out.println(myFile.getSize());

	}

	@GetMapping("link3")
	public void method3() {

	}

	@PostMapping("link4")
	public void method4(@RequestParam("files") List<MultipartFile> files) {
		files.stream().forEach((f) -> System.out.println(f.getOriginalFilename() + ", " + f.getSize()));
		System.out.println(files.get(0).getOriginalFilename());
		System.out.println(files.get(0).getSize());
		System.out.println(files.get(1).getOriginalFilename());
		System.out.println(files.get(1).getSize());
	}

	@GetMapping("link5")
	public void method5() {

	}

	@PostMapping("link6")
	public void method6(@RequestParam("files") MultipartFile[] files) {
		Arrays.asList(files).stream().forEach((f) -> System.out.println(f.getOriginalFilename() + ", " + f.getSize()));
	}

	@GetMapping("link7")
	public void method7() {

	}

	@PostMapping("link8")
	public void method8(Dto13 files) {
		Arrays.asList(files.getFiles()).stream().forEach((f) -> System.out.println(f.getOriginalFilename() + ", "
				+ f.getSize()));
	}

	@GetMapping("link9")
	public void method9() {

	}

	@PostMapping("link10")
	public void method10(Dto13 dto) {
		Arrays.asList(dto.getFiles()).stream().forEach((f) -> {
			try (InputStream is = f.getInputStream();
					BufferedInputStream bis = new BufferedInputStream(is);
					FileOutputStream fos = new FileOutputStream("copy_" + f.getOriginalFilename());
					BufferedOutputStream bos = new BufferedOutputStream(fos)) {
				byte[] datas = new byte[1024];
				int len = 0;

				while ((len = bis.read(datas)) != -1) {
					bos.write(datas, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	@PostMapping("link11")
	public void method11(MultipartFile[] files) {
		System.out.println(1);
		if (files.length != 0) {
			Arrays.asList(files).stream().forEach((f) -> {
				System.out.println(2);
				String path = "C:\\study\\filetest\\" + f.getOriginalFilename();

				File target = new File(path);
				if (!target.exists()) {
					System.out.println("make dirs");
					target.mkdirs();
				} else {
					System.out.println("make new name");
					
				}
				try {
					f.transferTo(target);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
