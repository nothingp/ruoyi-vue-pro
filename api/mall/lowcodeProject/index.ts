import { useAxios } from '@/hooks/web/useAxios'
import { LowcodeProjectVO,LowcodeProjectPageReqVO,LowcodeProjectExcelReqVO } from './types'

const request = useAxios()

// 查询商城项目配置列表
export const getPostPageApi = async (params: LowcodeProjectPageReqVO) => {
    return await request.get({ url: '/mall/lowcode-project/page', params })
}

// 查询商城项目配置详情
export const getPostApi = async (id: number) => {
    return await request.get({ url: '/mall/lowcode-project/get?id=' + id })
}

// 新增商城项目配置
export const createPostApi = async (data: LowcodeProjectVO) => {
    return await request.post({ url: '/mall/lowcode-project/create', data })
}

// 修改商城项目配置
export const updatePostApi = async (data: LowcodeProjectVO) => {
    return await request.put({ url: '/mall/lowcode-project/update', data })
}

// 删除商城项目配置
export const deletePostApi = async (id: number) => {
    return await request.delete({ url: '/mall/lowcode-project/delete?id=' + id })
}

// 导出商城项目配置 Excel
export const exportPostApi = async (params: LowcodeProjectExcelReqVO) => {
    return await request.download({ url: '/mall/lowcode-project/export-excel', params })
}
