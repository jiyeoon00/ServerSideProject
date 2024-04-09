package com.example.user.app.data.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
	private int itemId;
	private String itemName;
	private long itemPrice;
	private String imgName;
	private LocalDate regDate;
	private LocalDate updateDate;
}
