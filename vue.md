## vue启动

npm run serve

vue获取axios,获取后端端口进行转发

vue add axios

sudo vue add axios

**格式化代码：**

** Ctrl + Alt + L** idea

ctrl+shift+f查找文件

## vue-elementui

el-container:构建页面框架

-  el-aside:构建左侧菜单
- el-menu：左侧菜单栏，常用属性：

​       ：default-openeds：默认展开的菜单,通过菜单index来关联

​       ：default-active:默认选中的菜单,通过菜单index来关联

- el-submenu：可展开的菜单，常用属性：

​        index：菜单的下标，文本类型，不能是数值类型

- template：对应el-submenu的菜单名
- i：设置菜单图标，通过calss属性实现
  - [ ] el-icon-message
  - [ ] el-icon-menu
  - [ ] el-icon-setting

- el-menu-item :菜单子节点，不可再展开

​      index：菜单的下标，文本类型，不能是数值类型

```vuevue
               <el-menu>
<!--                   (item,index) in $router.options.routes-->
<!--                   通过index设置点击事件，通过index获取一维数组-->
                   <el-submenu v-for="(item,index) in $router.options.routes" :index="index+''">
<!--                       使用v-for遍历App的外层name属性-->
                       <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
<!--                       再遍历子菜单children属性，index2遍历二维数组选中下拉菜单-->
                       <!--                   (item2,index2)  :index="index+'-'+index2"-->
                       <el-menu-item v-for=" (item2,index2) in item.children" :index="index+'-'+index2" >{{item2.name}}</el-menu-item>
                   </el-submenu>
               </el-menu>
```

菜单menu与router的绑定

1.<el-menu>  添加router属性

2.在页面<router-view>标签，它是一个容器，动态渲染router

3.<el-menu-item>标签的index值就是要跳转的router



## 分页查询组件

vue add axios

totalElements：5总记录数

## Element UI表单数据校验

定义rules对象，在roles对象定义规则

```javascript
rules: {
    name: [
        { required: true, message: 'erro', trigger: 'blur' },
        { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ]
}
```

required: true,是否为必填项

message: 'erro',提示信息

trigger: 'blur'触发事件



跳转页面没有拿到query参数