let login = document.getElementById('login');
let enroll = document.getElementById('enroll');
let form_box = document.getElementsByClassName('form-box')[0];
let enroll_box = document.getElementsByClassName('enroll-box')[0];
let login_box = document.getElementsByClassName('login-box')[0];

enroll.addEventListener('click', () => {
    form_box.style.transform = 'translateX(104%)';
    login_box.classList.add('hidden');
    enroll_box.classList.remove('hidden');
})
login.addEventListener('click', () => {
    form_box.style.transform = 'translateX(0)';
    enroll_box.classList.add('hidden');
    login_box.classList.remove('hidden');
})

function checkSignin() {
    var signin_form = document.getElementById("signin_form")
    var name = document.getElementById("signin_name").value
    var password = document.getElementById("signin_password").value
    if (!name) {
        alert("用户名不能为空");
    } else if (!password) {
        alert("密码不能为空");
    } else {
        signin_form.submit();
    }

}
function checkSignup() {
    var signup_form = document.getElementById("signup_form")
    var name = document.getElementById("signup_name").value
    var emil = document.getElementById("signup_emil").value
    var password = document.getElementById("signup_password").value
    var confirmPassword = document.getElementById("signup_cnfirm_password").value

    if (!name) {
        alert("用户名不能为空")
    } else if (!password) {
        alert("密码不能为空")
    } else {
        signup_form.submit();
    }

}