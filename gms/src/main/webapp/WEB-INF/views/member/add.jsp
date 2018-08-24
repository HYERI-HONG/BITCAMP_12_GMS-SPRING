<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="contentBox">
<form id="add_form" name="add_form">
 	<div id="add_layout">
 	<label for="userid"><b>아이디</b></label>
    <input type="text" placeholder="아이디 입력" name="userid" required>
    
     <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="비밀번호 입력" name="password" required>
    
    <label for="email"><b>이 름</b></label>
    <input type="text" placeholder="이 름 입 력" name="name" required>
    
    <label for="email"><b>주민번호(생년월일-앞자리)</b></label>
    <input type="text" placeholder="(예시) 900101-1" name="ssn" required>
        
       <label for="userid"><b>소속팀</b></label>
           <input type="radio" name="teamid" 
           		value="LP" />레츠플레이팀
           <input type="radio" name="teamid" 
           		value="GG" />지은이랑지은집팀
           <input type="radio" name="teamid" 
           		value="TurtleKing" />거북왕팀
           <input type="radio" name="teamid" 
           		value="CodingStar" />언프리티코딩스타팀
        <br /><br />
         <label for="userid"><b>프로젝트역할</b></label>
        <select name="roll" id="roll">
        	 <option value="팀장">팀장</option>
        	 <option value="프론트 담당">프론트개발</option>
        	 <option value="백단 담당">백단개발</option>
        	 <option value="안드로이드 담당">안드로이드개발</option>
        	 <option value="무임승차">무임승차</option>
        </select>
       <br /><br />
        <label for="userid"><b>수강과목</b></label>
        <input type="checkbox" name="subject" 
        	value="JAVA" checked="checked" /> JAVA
        <input type="checkbox" name="subject" value="C" /> C
        <input type="checkbox" name="subject" value="JSP" /> JSP
        <input type="checkbox" name="subject" value="PHP" /> PHP
        <input type="checkbox" name="subject" value="Node.js" /> Node.js
        <input type="checkbox" name="subject" value="Linux" /> Linux
        <input type="checkbox" name="subject" value="HTML" /> HTML
        <input type="checkbox" name="subject" value="Spring" /> Spring
        <br><br>
		<input id="join_submit" type="button"  value = "등록" />	
    </div>
    </form>
</div>
