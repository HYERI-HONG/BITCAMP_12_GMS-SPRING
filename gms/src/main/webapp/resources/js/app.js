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
			location.href = app.x()+'/member/login';
		});
		$('#logout_btn').click(()=>{
			location.href = app.x()+'/member/logout';
		});
		$('#join_btn').click(()=>{
			location.href = app.x()+'/move/member/add';
		});
		$('#join_submit').click(()=>{
			location.href = app.x()+'/member/add';
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


