"use strict";
var app = app || {}
var app={
	init : x =>{
		console.log('step1');
		app.session.context(x);
		app.onCreate();
	},
	onCreate : ()=>{
		console.log('step3');
		app.setContentView();
		$('#login_btn').click(()=>{
			location.href = app.x()+'/move/member/login';
		});
		$('#login_submit').click(()=>{
			$('#loginForm').attr({
				action:app.x()+"/member/login",
				method:"POST"
			})
			.submit();
		});
		$('#logout_btn').click(()=>{
			location.href = app.x()+'/member/logout';
		});
		$('#join_btn').click(()=>{
			location.href = app.x()+'/move/member/add';
		});
		$('#join_submit').click(()=>{
			/*var form = document.getElementById('joinForm');
			form.action = app.x()+"/member/add";
			form.method = "POST";
			form.submit();	*/
			$('#joinForm')
			.attr({
				action:app.x()+"/member/add",
				method:"POST"
			})
			.submit();
		});
		$('#goUpdate').click(()=>{
			location.href = app.x()+'/move/member/modify';
		});
		$('#update_submit').click(()=>{
			$('#updateForm').attr({
				action:app.x()+"/member/modify",
				method:"POST"
			}).submit();
			
		});
		$('#goDelete').click(()=>{
			location.href = app.x()+'/move/member/remove';
		});
		$('#delete_submit').click(()=>{
			$('#deleteForm').attr({
				action:app.x()+"/member/remove",
				method:"POST"
			}).submit();
			
		});
		
	},
	setContentView : ()=>{
		console.log('step4  '+app.session.path('js'));
	}
};
app.session = {
		context : x=>{
			console.log('step2');
			sessionStorage.setItem('context',x);
			sessionStorage.setItem('js',x+'/resources/js');
			sessionStorage.setItem('css',x+'/resources/css');
			sessionStorage.setItem('img',x+'/resources/img');
		}, 
		path : x=>{
			return sessionStorage.getItem(x);
		}	
};
app.x =()=>{
	return app.session.path('context');
};
app.j =()=>{
	return app.session.path('js');
};
app.c =()=>{
	return app.session.path('css');
};
app.i =()=>{
	return app.session.path('img');
};

var user = user || {}
var user = {
	setUser : x=>{
		sessionStorage.setItem('userid',x.userid);
		sessionStorage.setItem('teamid',x.teamid);
		sessionStorage.setItem('name',x.name);
		sessionStorage.setItem('roll',x.roll);
		sessionStorage.setItem('gender',x.gender);
		sessionStorage.setItem('age',x.age);
		sessionStorage.setItem('ssn',x.ssn);
		sessionStorage.setItem('password',x.password);
	},
	getUser : x=>{
		return sessionStorage.getItem(x);
	}
}



