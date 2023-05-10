let menuList = [
    {
        id: 1293,
        name: '首页',
        icon: 'fa fa-server',
        url: 'sa-html/sa-doc.html',
        parentId: 0
    },
    {
        id: 1,
        name: '用户管理',
        icon: 'fa fa-graduation-cap',
        info: '对用户列表、添加、统计等等...',
        childList: [
            {
                id: '1-1',
                name: '管理员管理',
                url: 'user/admin.html',
                parentId: 1
            },
            {
                id: '1-2',
                name: '用户管理',
                url: 'user/user.html',
                parentId: 1
            }
        ],
        parentId: 0
    },
    {
        id: 2,
        name: '权限控制',
        icon: 'fa fa-paper-plane',
        info: '对系统角色权限的分配等设计，敏感度较高，请谨慎授权',
        childList: [
            {
                id: '2-1',
                name: '角色列表',
                url: 'permission/role.html',
                parentId: 2
            },
            {
                id: '2-2',
                name: '菜单列表',
                url: 'permission/menu.html',
                parentId: 2
            }
        ],
        parentId: 0
    },
    {
        id: 3,
        name: '产品管理',
        icon: 'fa fa-line-chart',
        info: '对产品的增删改查、维护',
        childList: [
            {
                id: '3-1',
                name: '产品列表',
                url: 'products/floor.html',
                parentId: 3
            },
            {
                id: '3-2',
                name: '产品发表',
                url: 'products/add.html',
                parentId: 3
            },
            {
                id: '3-3',
                name: '产品系列',
                url: 'post/add.html',
                parentId: 3
            }
        ],
        parentId: 0
    },
    {
        id: 4,
        name: '信息管理',
        icon: 'fa fa-cog',
        info: '对系统运行时的一些参数的设置',
        childList: [
            {
                id: '4-1',
                name: '留言管理',
                url: 'setting/website.html',
                info: '对服务器参数的设置',
                parentId: 4
            },
            {
                id: '4-2',
                name: '加盟管理',
                url: 'setting/rotation.html',
                parentId: 4
            },

        ],
        parentId: 0
    },
    {
        id: 5,
        name: '店铺管理',
        icon: 'fa fa-cog',
        info: '管理其他内容',
        childList: [
            {
                id: '4-1',
                name: '专卖店管理',
                url: 'setting/website.html',
                info: '对服务器参数的设置',
                parentId: 4
            },
            {
                id: '4-2',
                name: '品牌历程管理',
                url: 'setting/rotation.html',
                parentId: 4
            },
            {
                id: '4-3',
                name: '品牌荣誉管理',
                url: 'setting/website.html',
                info: '对服务器参数的设置',
                parentId: 4
            },
            {
                id: '4-4',
                name: '售货信息管理',
                url: 'setting/rotation.html',
                parentId: 4
            },
            {
                id: '4-5',
                name: '工程信息管理',
                url: 'setting/rotation.html',
                parentId: 5
            }

        ],
        parentId: 0
    },
   
]