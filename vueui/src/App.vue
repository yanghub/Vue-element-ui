<template>
        <!--    使用Index页面把单个页面动态加载到App-->
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <!--            添加-->
                <!-- efault-openeds默认打开选项-->
                <el-menu router :default-openeds="['0','1']">
                    <!--                   (item,index) in $router.options.routes-->
                    <!--                   通过index设置点击事件，通过index获取一维数组,v-if的show成立再遍历-->
                    <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''" v-if="item.show">
                        <!--                       使用v-for遍历App的外层name属性-->
                        <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
                        <!--                       再遍历子菜单children属性，index2遍历二维数组选中下拉菜单-->
                        <!--                   (item2,index2)  :index="index+'-'+index2"-->
                        <!--                    再通过index设置点击事件跳转index="index+'-'+index2"---->
                        <!--                    再通过三元运算符判断，当地址栏路径跟对象路径相等，添加class属性is-active（变蓝）-->
                        <el-menu-item v-for=" (item2,index2) in item.children" :index="item2.path"
                                      :class="$route.path==item2.path?'is-active':''">{{item2.name}}</el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>查看</el-dropdown-item>
                            <el-dropdown-item>新增</el-dropdown-item>
                            <el-dropdown-item>删除</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <span>羊羊羊</span>
                </el-header>
                <el-main>
                    <!--       <div>  router-view嵌套到App页面接口配置动态路由跳转-->
                    <router-view></router-view>
                </el-main>
            </el-container>

        </el-container>

</template>

<script>
    export default {
        name: "App"
    }
</script>

<style scoped>

</style>