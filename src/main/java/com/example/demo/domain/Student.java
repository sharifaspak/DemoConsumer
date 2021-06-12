/**
 * 
 */
package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author aspak.avesh.sharif
 *
 */

@AllArgsConstructor
@Getter
@Setter
@Component
public class Student {
	@Id
	public String id;
	@NonNull
	public String registration;
	public String name;

}
