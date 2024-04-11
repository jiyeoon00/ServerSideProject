package com.example.user.app.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
	private int commentId;
	private String custId;
	private String commentContent;
	private LocalDateTime commentRegdate;
	private LocalDateTime commentUpdate;
	private int boardId;
}
