package com.example.user.app.data.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	private int boardId;
	private String custId;
	private String boardTitle;
	private String boardContent;
	private LocalDateTime boardRegdate;
	private LocalDateTime boardUpdate;
	private int boardCnt;
	// 조회시 comment 개수 확인
	private int commentCnt;
	private List<CommentDto> commentList;
}
