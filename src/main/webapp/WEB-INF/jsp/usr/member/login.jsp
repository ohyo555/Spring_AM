<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="MEMBER LOGIN"></c:set>
<%@ include file="../common/head.jspf"%>

<style>
	section > div div {
		margin-bottom: 10px; 
	}
</style>

<section class="mt-8 text-xl px-4">
	<div class="mx-auto">
		<form action="../member/doLogin" method="POST">
			<table class="login-box table-box-1" border="1">
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input class="input input-bordered input-primary w-full max-w-xs" autocomplete="off" type="text" placeholder="아이디를 입력해주세요" name="loginId" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input class="input input-bordered input-primary w-full max-w-xs" autocomplete="off" type="text" placeholder="비밀번호를 입력해주세요" name="loginPw" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input class="btn btn-outline btn-info" type="submit" value="로그인" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div class="btns mt-5">
			<button class="btn btn-outline" type="button" onclick="history.back();">뒤로가기</button>
			<button class="btn btn-outline" type="button" onclick="../member/findId">아이디찾기</button>
			<button class="btn btn-outline" type="button" onclick="../member/findPw">비밀번호찾기</button>
		</div>
	</div>
</section>



<%@ include file="../common/foot.jspf"%>