import request from '@/utils/request'

// 查询科室列表
export function listAdo(query) {
  return request({
    url: '/hospital/ado/list',
    method: 'get',
    params: query
  })
}

// 查询科室详细
export function getAdo(adoId) {
  return request({
    url: '/hospital/ado/' + adoId,
    method: 'get'
  })
}

// 新增科室
export function addAdo(data) {
  return request({
    url: '/hospital/ado',
    method: 'post',
    data: data
  })
}

// 修改科室
export function updateAdo(data) {
  return request({
    url: '/hospital/ado',
    method: 'put',
    data: data
  })
}

// 删除科室
export function delAdo(adoId) {
  return request({
    url: '/hospital/ado/' + adoId,
    method: 'delete'
  })
}
