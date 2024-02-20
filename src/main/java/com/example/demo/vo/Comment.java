package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String relTypeCode;
	private int level;
	private String comment;
	private int relId;
	private int goodReactionPoint;
	private int badReactionPoint;
	private int sum;
	
	private String extra__writer;
	
	private boolean userCanModify;
	private boolean userCanDelete;

}