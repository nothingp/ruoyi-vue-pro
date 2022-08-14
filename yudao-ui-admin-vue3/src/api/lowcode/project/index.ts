import { useAxios } from '@/hooks/web/useAxios'
import { LowcodeProjectVO, LowcodeProjectPageReqVO, LowcodeProjectExcelReqVO } from './types'

const request = useAxios()

// 查询商城项目配置列表
export const getLowcodeProjectPageApi = async (params: LowcodeProjectPageReqVO) => {
  return await request.get({ url: '/lowcode/project/page', params })
}

// 查询商城项目配置详情
export const getLowcodeProjectApi = async (id: number) => {
  return await request.get({ url: '/lowcode/project/get?id=' + id })
}

// 新增商城项目配置
export const createLowcodeProjectApi = async (data: LowcodeProjectVO) => {
  return await request.post({ url: '/lowcode/project/create', data })
}

// 修改商城项目配置
export const updateLowcodeProjectApi = async (data: LowcodeProjectVO) => {
  return await request.put({ url: '/lowcode/project/update', data })
}

// 删除商城项目配置
export const deleteLowcodeProjectApi = async (id: number) => {
  return await request.delete({ url: '/lowcode/project/delete?id=' + id })
}

// 导出商城项目配置 Excel
export const exportLowcodeProjectApi = async (params: LowcodeProjectExcelReqVO) => {
  return await request.download({ url: '/lowcode/project/export-excel', params })
}
