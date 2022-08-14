import { useAxios } from '@/hooks/web/useAxios'
import { ProjectVO, ProjectPageReqVO, ProjectExcelReqVO } from './types'

const request = useAxios()

// 查询商城项目配置列表
export const getProjectPageApi = async (params: ProjectPageReqVO) => {
  return await request.get({ url: '/lowcode/project/page', params })
}

// 查询商城项目配置详情
export const getProjectApi = async (id: number) => {
  return await request.get({ url: '/lowcode/project/get?id=' + id })
}

// 新增商城项目配置
export const createProjectApi = async (data: ProjectVO) => {
  return await request.post({ url: '/lowcode/project/create', data })
}

// 修改商城项目配置
export const updateProjectApi = async (data: ProjectVO) => {
  return await request.put({ url: '/lowcode/project/update', data })
}

// 删除商城项目配置
export const deleteProjectApi = async (id: number) => {
  return await request.delete({ url: '/lowcode/project/delete?id=' + id })
}

// 导出商城项目配置 Excel
export const exportProjectApi = async (params: ProjectExcelReqVO) => {
  return await request.download({ url: '/lowcode/project/export-excel', params })
}
