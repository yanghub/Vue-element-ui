import Vue from 'vue'
import VueRouter from 'vue-router'
import ShopManage from "../views/ShopManage";
import AddShop from "../views/AddShop";
import Index from "../views/Index";
import ShopUpdate from "../views/ShopUpdate";
//路由动态加载
Vue.use(VueRouter)
//后面""或''均可以
const routes = [
    {
        path: "/",
        name: '服装商品管理',
        component: Index,
        //show等于true遍历
        show:true,
        //配置默认跳转页面redirect
        redirect: "ShopManage",
        //  配置子页面
        children: [
            {
                path: "/ShopManage",
                name: "查询服装",
                component: ShopManage
            },
            {
                path: "/AddShop",
                name: "添加服装",
                component: AddShop
            }

        ]
    },
    {
        path:'/update',
        name:'商品更新',
        component: ShopUpdate,
        show: false
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
