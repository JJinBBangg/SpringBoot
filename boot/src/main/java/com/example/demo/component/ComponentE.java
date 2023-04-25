package com.example.demo.component;

import org.springframework.stereotype.*;

import lombok.*;

@Component
@RequiredArgsConstructor
@Data
public class ComponentE {
	
	private final ComponentD comp;
	
	
}
