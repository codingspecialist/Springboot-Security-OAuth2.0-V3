<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/post" method="post">

		<div class="form-group">
			<input type="text" class="form-control" placeholder="Enter Title" name="title" />
		</div>

		<div class="form-group">
			<textarea rows="" cols="5" class="form-control" name="content"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">글쓰기완료</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>