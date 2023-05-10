<template>
    <!-- <div>
    <h1>登录页面</h1>
    用户名: <input type="text" v-model="loginForm.username"/>
    密码: <input type="password" v-model="loginForm.password"/>
    <button @click="login">登录</button>
  </div> -->

    <div class="login_container">
        <div class="login_box">
            <!-- 1.头像 -->
            <div class="logo_box">
                <img src="../assets/logo.png" />
            </div>
            <!-- 2.表单 -->
            <el-form :rules="rules" ref="loginForm" :model="loginForm" class="login_form">
                <el-form-item label="用户名" prop="username">
                    <el-input v-model="loginForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="loginForm.password"></el-input>
                </el-form-item>
                <!-- 按钮 -->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button type="info">重置</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            loginForm: {
                username: 'admin',
                password: '123456'
            },
            rules: {
                //用户名验证
                username: [
                    { required: true, message: '请输入名称', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 6, max: 8, message: '长度6-8个字符', trigger: 'blur' }
                ]
            }
        }
    },
    methods: {
        login() {
            this.$refs.loginForm.validate(async (isOK) => {
                console.log('验证: ', isOK)
                if(isOK == false) {
                    this.$message.error('验证失败');
                    return;
                }
                let ret = await this.http.post('login', this.loginForm)
                console.log(ret);

                if(ret.meta.status != 200) {
                    this.$message.error('登录失败');
                    return;
                }

                //将bearerToken保存到本地存储
                sessionStorage.setItem('token', ret.data.token)

                //如果登录成功跳转到首页
                this.$router.push('/home');
            })

        },
        
    }
}
</script>


<style lang="less" scoped>
.login_container {
    background-color: gray;
    height: 100%;
}

.login_box {
    width: 450px;
    height: 300px;
    background-color: white;
    border-radius: 5px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);

    .logo_box {
        height: 130px;
        width: 130px;
        border: 1px solid white;
        border-radius: 50%; //圆角
        padding: 10px; //内边距
        box-shadow: 0 0 10px gray; //阴影
        position: absolute; //位置
        left: 50%;
        background-color: white;
        transform: translate(-50%, -50%); //位移

        img {
            width: 100%;
            height: 100%;
            border-radius: 40%;
            background-color: white;
        }
    }

    .login_form {
        position: absolute;
        bottom: 0;
        width: 100%;
        padding: 0 20px;
        box-sizing: border-box;
    }

    .btns {
        display: flex;
        justify-content: flex-end;
    }

}</style>