package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.Article;
import com.example.demo.vo.Comment;
import com.example.demo.vo.ReactionPoint;

@Mapper
public interface CommentRepository {

	@Select("""
			SELECT C.*, M.nickname AS extra__writer, SUM(C.goodreactionPoint) AS `sum`
			FROM `comment` AS C
			INNER JOIN `member` AS M
			ON C.memberId = M.id
			LEFT JOIN reactionPoint AS R
			ON C.id = R.commentId
			WHERE C.relId = #{relId}
			GROUP BY C.id
			ORDER BY regDate DESC
			""")
	List<Comment> getForPrintComments(int loginedMemberId, String relTypeCode, int relId);

	@Insert("""
			INSERT INTO `comment` 
			SET regDate = NOW(),
			updateDate = NOW(),
			`comment` = #{comment},
			memberId = #{loginedMemberId},
			level = 1,
			relTypeCode = #{relTypeCode},
			relId = #{relId}
			""")
	void writeComment(int loginedMemberId, String relTypeCode, int relId, String comment);

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
			FROM `comment`
			WHERE id = #{id}
			""")
	public Comment getComment(int id);
	

	@Update("""
			UPDATE `comment`
				<set>
					<if test="commnet != null and commnet != ''">`comment` = #{comment},</if>
					updateDate = NOW()
				</set>
			WHERE id = #{id}
				""")
	void modifyComment(int id, String comment);

	@Delete("DELETE FROM `comment` WHERE id = #{id}")
	void deleteComment(int id);
}