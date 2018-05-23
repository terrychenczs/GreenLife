//== Class Definition
var SnippetLogin = function () {
    var urlpath = "/ssm_shiro";
    var login = $('#m_login');

    var showErrorMsg = function (form, type, msg) {
        var alert = $('<div class="m-alert m-alert--outline alert alert-' + type + ' alert-dismissible" role="alert">\
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>\
			<span></span>\
		</div>');

        form.find('.alert').remove();
        alert.prependTo(form);
        alert.animateClass('fadeIn animated');
        alert.find('span').html(msg);
    }

    //== Private Functions

    var displaySignUpForm = function () {
        login.removeClass('m-login--forget-password');
        login.removeClass('m-login--signin');

        login.addClass('m-login--signup');
        login.find('.m-login__signup').animateClass('flipInX animated');
    }

    var displaySignInForm = function () {
        login.removeClass('m-login--forget-password');
        login.removeClass('m-login--signup');

        login.addClass('m-login--signin');
        login.find('.m-login__signin').animateClass('flipInX animated');
    }

    var displayForgetPasswordForm = function () {
        login.removeClass('m-login--signin');
        login.removeClass('m-login--signup');

        login.addClass('m-login--forget-password');
        login.find('.m-login__forget-password').animateClass('flipInX animated');
    }

    var handleFormSwitch = function () {
        $('#m_login_forget_password').click(function (e) {
            e.preventDefault();
            displayForgetPasswordForm();
        });

        $('#m_login_forget_password_cancel').click(function (e) {
            e.preventDefault();
            displaySignInForm();
        });

        $('#m_login_signup').click(function (e) {
            e.preventDefault();
            displaySignUpForm();
        });

        $('#m_login_signup_cancel').click(function (e) {
            e.preventDefault();
            displaySignInForm();
        });
    }

    //账户登录
    var handleSignInFormSubmit = function () {
        $('#m_login_signin_submit').click(function (e) {
            e.preventDefault();
            var btn = $(this);
            var form = $(this).closest('form');

            form.validate({
                rules: {
                    username: {
                        required: true,
                    },
                    password: {
                        required: true
                    }
                }
            });

            if (!form.valid()) {
                return;
            }

            btn.addClass('m-loader m-loader--right m-loader--light').attr('disabled', true);

            form.ajaxSubmit({
                type: "post",
                dataType: "json",
                async: false,
                url: $('#Userlogin').attr('action'),
                success: function (msg) {
                    console.log(msg);
                    // similate 2s delay

                    btn.removeClass('m-loader m-loader--right m-loader--light').attr('disabled', false);

                    if (msg.code == 1) {
                        showErrorMsg(form, 'success', msg.msg);
                        var url = msg.items[0].pid;
                        window.open(url,"_self");
                    }else {
                        showErrorMsg(form, 'danger', msg.msg);
                    }
                }
            });

        });
    }

    // 注册账户
    var handleSignUpFormSubmit = function () {

        var url = urlpath + '/user/check';
        $('#createForm').validate({
            rules: {
                username: {
                    required: true,
                    rangelength: [6, 10],
                    remote: {
                        url: url,
                        type: "post",
                        data: {
                            username: function () {
                                return $('#createForm input[name="username"]').val();
                            }
                        }
                    }
                },
                workNo: {
                    //required: true,
                    rangelength: [3, 5]
                },
                age: {
                    //required: true,
                    digits: true,
                    range: [18, 99]
                },
                phone: {
                    //required: true,
                    digits: true,
                    rangelength: [11, 11],
                    remote: {
                        type: 'post',
                        /*dataType: 'json',*/
                        url: url,
                        data: {
                            phone: function () {
                                return $('#createForm input[name="phone"]').val();
                            }
                        }
                    }
                },
                email: {
                    //required: true,
                    email: true,
                    remote: {
                        url: url,
                        type: 'post',
                        /*dataType:'json',*/
                        data: {
                            email: function () {
                                return $('#createForm input[name="email"]').val();
                            }
                        }
                    }
                },
                address: {
                    //required: true
                },
                password: {
                    required: true,
                    minlength: 6
                },
                rpassword: {
                    required: true,
                    equalTo: "#password"
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    rangelength: "用户名必须为6-10位数组成",
                    remote: "该用户名已被注册，请重新填写"
                },
                workNo: {
                    //required: "请输入你的工号",
                    rangelength: "工号必须为3-5位数组成"
                },
                age: {
                    //required: "请输入你的年龄",
                    digits: "请输入正确的年龄",
                    range: "输入的年龄必须在18-99岁之间"
                },
                phone: {
                    required: "请输入你的手机号",
                    digits: "请输入正确手机号",
                    rangelength: "请输入11位手机号",
                    remote: "该手机号已被注册，请重新填写"
                },
                email: {
                    required: "请输入你的邮箱",
                    email: "请输入一个正确的邮箱",
                    remote: "该邮箱已被注册，请重新填写"
                },
                address: {
                    //required: "请输入你的现住地址"
                },
                password: {
                    required: "请输入你的密码",
                    minlength: "密码长度不能小于 5 个字母"
                },
                rpassword: {
                    required: "请输入你的密码",
                    equalTo: "两次密码输入不一致"
                }
            }
        });

        $('#m_login_signup_submit').click(function (e) {
            e.preventDefault();

            var btn = $(this);
            var form = $(this).closest('form');

            btn.addClass('m-loader m-loader--right m-loader--light').attr('disabled', true);

            form.ajaxSubmit({
                type: 'post',
                dataType: 'json',
                //data:$("#createForm").serialize(),
                url: $("#createForm").attr("action"),
                success: function (msg) {
                    console.log(msg);
                    var code = msg.code;
                    btn.removeClass('m-loader m-loader--right m-loader--light').attr('disabled', false);
                    form.clearForm();
                    form.validate().resetForm();

                    if (msg.code == 1) {
                        displaySignInForm();
                        var signInForm = login.find('.m-login__signin form');
                        signInForm.clearForm();
                        signInForm.validate().resetForm();
                        showErrorMsg(signInForm, 'success', msg.msg);
                    }
                    else {
                        showErrorMsg(form, 'danger', msg.msg);
                    }
                }
            });
        });
    }

    //验证邮箱
    /*   var handleForgetPasswordFormSubmit = function() {
           $('#m_login_forget_password_submit').click(function(e) {
               e.preventDefault();

               var btn = $(this);
               var form = $(this).closest('form');

               form.validate({
                   rules: {
                       email: {
                           required: true,
                           email: true
                       }
                   }
               });

               if (!form.valid()) {
                   return;
               }

               btn.addClass('m-loader m-loader--right m-loader--light').attr('disabled', true);

               form.ajaxSubmit({
                   url: '',
                   success: function(response, status, xhr, $form) {
                       // similate 2s delay
                       setTimeout(function() {
                           btn.removeClass('m-loader m-loader--right m-loader--light').attr('disabled', false); // remove
                           form.clearForm(); // clear form
                           form.validate().resetForm(); // reset validation states

                           // display signup form
                           displaySignInForm();
                           var signInForm = login.find('.m-login__signin form');
                           signInForm.clearForm();
                           signInForm.validate().resetForm();

                           showErrorMsg(signInForm, 'success', 'Cool! Password recovery instruction has been sent to your email.');
                       }, 2000);
                   }
               });
           });
       }*/
    /*    var loginTest = function () {
            $("#m_login_forget_password_submit").click(function () {
                if ($("#userName").val() == null || $("#userName").val() == '') {
                    alert("请输入用户名！");
                } else if ($("#pwd").val() == null || $("#pwd").val() == "") {
                    alert("密码不能为空！");
                } else {
                    document.getElementById("form").submit();
                }
            })
        }*/

    //== Public Functions
    return {
        // public functions
        init: function () {
            handleFormSwitch();
            handleSignInFormSubmit();
            handleSignUpFormSubmit();
            //handleForgetPasswordFormSubmit();
            //loginTest();
        }
    };
}();

//== Class Initialization
jQuery(document).ready(function () {
    SnippetLogin.init();
});