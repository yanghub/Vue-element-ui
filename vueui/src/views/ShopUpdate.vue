<template>
    <el-form style="width:50%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">

        <el-form-item label="编号">
            <el-input v-model="ruleForm.id" readOnly></el-input>
        </el-form-item>

        <el-form-item label="朝代" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="风格" prop="style">
            <el-input v-model="ruleForm.style"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>


<script>
    export default {
        data() {
            return {
                //ruleForm对象
                ruleForm: {
                    id:'',
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
            submitForm(formName) {
                //指代当前对象使用_this回调
                const _this=this
                //判定表单通过校验
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        // alert(111)
                        axios.put('http://localhost:8181/shop/update/',this.ruleForm).then(function(resp){
                            // console.log(resp.data)  //f12后台调试
                            // alert(111)
                            if(resp.data == 'success'){
                                //点击确定后添加
                                _this.$alert('《'+_this.ruleForm.name+'》修改成功!', '消息', {
                                    confirmButtonText: '确定',
                                    callback: action => {
                                        _this.$router.push('/ShopManage')
                                    }
                                })
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
        },
        //使用$route拿，修改的id参数
        created(){
            // alert(this.$route.query.id)  //测试能否拿出id
            //修改数据库内容
            const  _this =this
            axios.get('http://localhost:8181/shop/findById/'+this.$route.query.id).then(function (resp) {
                _this.ruleForm  =resp.data
            })
            // console.log(this.$route)
        }
    }
</script>