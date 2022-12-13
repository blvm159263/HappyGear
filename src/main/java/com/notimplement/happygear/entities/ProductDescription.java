package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_product_description")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private Integer productId;
	
	@Column(name = "kepcap")
	private String keycap;
	
	@Column(name = "switch")
	private String switchKeyBoard;
	
	@Column(name = "type_keyboard")
	private String typeKeyboard;
	
	@Column(name = "connect")
	private String connect;
	
	@Column(name = "led")
	private String led;
	
	@Column(name = "freigh")
	private String freigh;
	
	@Column(name = "item_dimension")
	private String itemDimension;
	
	@Column(name = "cpu")
	private String cpu;
	
	@Column(name = "ram")
	private String ram;
	
	@Column(name = "operating_system")
	private String operatingSystem;
	
	@Column(name = "battery")
	private String battery;
	
	@Column(name = "hard_disk")
	private String hardDisk;
	
	@Column(name = "graphic_card")
	private String graphicCard;
	
	@Column(name = "key_board")
	private String keyBoard;
	
	@Column(name = "audio")
	private String audio;
	
	@Column(name = "wifi")
	private String wifi;
	
	@Column(name = "bluetooth")
	private String bluetooth;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "frame_rate")
	private String frameRate;
	
	@Column(name = "screen_size")
	private String screenSize;
	
	@Column(name = "screen_type")
	private String screenType;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonManagedReference
	private Category desCategory;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	@JsonManagedReference
	private Product product;
}
