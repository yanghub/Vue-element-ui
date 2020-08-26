<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="朝代"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="style"
                    label="风格 "
                    width="120">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteshop(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--    page-size 设置页数,:total总数据动态获取数据total,pagesize-->
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size="pageSize"
                :total="total"
                 @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            //删除数据
            deleteshop(row){
                const  _this =this
                axios.delete('http://localhost:8181/shop/deleteById/'+row.id).then(function (resp) {
                    _this.$alert('《'+row.name+'》删除成功!', '消息', {
                        confirmButtonText: '确定',
                        callback: action => {
                            //动态刷新页面，则不需要跳转
                            window.location.reload()
                            // _this.$router.push('/ShopManage')
                        }
                    })
                })
            },
            //修改数据
            edit(row) {
                // alert(row.id)
                this.$router.push({
                    path:'/update',
                    // query取id
                    query:{
                        name: '商品更新',
                        id:row.id,
                        name:row.name
                    }
                })
                // alert(this.$route.params.id)
                // alert(this.$route.query.id)
                // console.log(row);
            },
            //@current-change检测点击页数
            page(currentPage){
                // alert(currentPage)  //用来测试显示页码信息,currentPage-1返回真实页码
                const  _this =this
                axios.get('http://localhost:8181/shop/findAll/'+(currentPage-1)+'/6').then(function (resp){
                    _this.tableData =resp.data.content
                    _this.PageSize =resp.data.size
                    _this.total =resp.data.totalElements
                })
            }

        },
        data() {
            return {
                //静态测试数据
                pageSize:'1',
                total:null,
                tableData: null
            }
        },
        created(){
            //console.log(resp)控制台查看是否返回resp的数据
            const  _this =this
            // alert(11)  //测试是否进入created方法
            axios.get('http://localhost:8181/shop/findAll/0/6').then(function (resp){
                // console.log(resp) //f12查询控制台是否传入成功content数据
                _this.tableData =resp.data.content
                //传入total总记录数
                _this.PageSize =resp.data.size
                _this.total =resp.data.totalElements
            })

        }
    }
</script>