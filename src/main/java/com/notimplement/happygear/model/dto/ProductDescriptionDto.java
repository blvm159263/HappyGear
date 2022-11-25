package com.notimplement.happygear.model.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescriptionDto {

	private Integer productId;

	@NotNull(message = "Category can not null!!!")
	private Integer categoryId;
	
	private String keycap;
	private String switchKeyBoard;
	private String typeKeyboard;
	private String connect;
	private String led;
	private String freigh;
	private String itemDimension;
	private String cpu;
	private String ram;
	private String operatingSystem;
	private String battery;
	private String hardDisk;
	private String graphicCard;
	private String keyBoard;
	private String audio;
	private String wifi;
	private String bluetooth;
	private String color;
	private String frameRate;
	private String screenSize;
	private String screenType;
}
