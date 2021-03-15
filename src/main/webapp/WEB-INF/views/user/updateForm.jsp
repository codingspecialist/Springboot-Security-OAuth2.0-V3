<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<form>
	<input type="hidden" id="id" value="${id}" />
	<input type="text" value="${principal.user.username}" placeholder="Username" id="username"  readonly="readonly"/> <br/>
	<input type="password" value="" placeholder="Password" id="password" /> <br/>
	<input type="email" value="${principal.user.email}" placeholder="Email" id="email" /> <br/>
	<button id="btn-update">회원수정</button>
</form>

<script>
	$("#btn-update").on("click", (e)=> {
		e.preventDefault();
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		let id = $("#id").val();

		console.log(data);

		$.ajax({
			type: "PUT",
			url: "/user/"+id,
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done((res)=>{
			console.log(res);
			if(res.statusCode === 1){
				alert("수정에 성공하였습니다.");
				location.href = "/";
			}else{
				alert("수정에 실패하였습니다.");
			}
		});

	});
</script>
<%@ include file="../layout/footer.jsp"%>

