<template>
<!--    前端做验证是否输入了内容-->
<!--    model绑定ruleForm对象,设置数据绑定;rules绑定校验规则-->
    <el-form style="width:50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="朝代" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="风格" prop="style">
            <el-input v-model="ruleForm.style"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">添加</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
<!--            <el-button @click="test()">test</el-button>-->
        </el-form-item>
    </el-form>
</template>
<script>
    export default {
        data() {
            return {
                //ruleForm对象
                ruleForm: {
                    name: '',
                    style: ''
                },
                rules: {
                    name: [
                        { required: true, message: '朝代不能为空', trigger: 'blur' },
                    ],
                    style: [
                        { required: true, message: '风格不能为空', trigger: 'blur' },
                    ]
                }
            };
        },
        methods: {
            test(){
                console.log(this.ruleForm)
            },
            submitForm(formName) {
                //指代当前对象使用_this回调
                const _this=this
                //判定表单通过校验
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/shop/save/',this.ruleForm).then(function(resp){
                            if(resp.data == 'success'){
                                //点击确定后添加
                                _this.$alert('《'+_this.ruleForm.name+'》添加成功!', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/ShopManage')
                                    }
                                })
                                //直接添加方式
                                // _this.$router.push('/ShopManage')
                                _this.$message({
                                    message: '恭喜你，添加成功',
                                    type: 'success'
                                });
                            }
                        })

                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                //触发重置使用resetFields()
                this.$refs[formName].resetFields();
            }
        }
    }
</script>