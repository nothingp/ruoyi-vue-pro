import request from '@/utils/request'

// 创建商城项目配置
export function createLowcodeProject(data) {
  return request({
    url: '/lowcode/project/create',
    method: 'post',
    data: data
  })
}

// 更新商城项目配置
export function updateLowcodeProject(data) {
  return request({
    url: '/lowcode/project/update',
    method: 'put',
    data: data
  })
}

// 删除商城项目配置
export function deleteLowcodeProject(id) {
  return request({
    url: '/lowcode/project/delete?id=' + id,
    method: 'delete'
  })
}

// 获得商城项目配置
export function getLowcodeProject(id) {
  return request({
    url: '/lowcode/project/get?id=' + id,
    method: 'get'
  })
}

// 获得商城项目配置分页
export function getLowcodeProjectPage(query) {
  return request({
    url: '/lowcode/project/page',
    method: 'get',
    params: query
  })
}

// 导出商城项目配置 Excel
export function exportLowcodeProjectExcel(query) {
  return request({
    url: '/lowcode/project/export-excel',
    method: 'get',
    params: query,
    responseType: 'blob'
  })
}
