import request from '@/utils/request'

// 查询预约信息列表
export function listInfo(query) {
  return request({
    url: '/hospital/info/list',
    method: 'get',
    params: query
  })
}

// 查询预约信息详细
export function getInfo(appointId) {
  return request({
    url: '/hospital/info/' + appointId,
    method: 'get'
  })
}

// 新增预约信息
export function addInfo(data) {
  return request({
    url: '/hospital/info',
    method: 'post',
    data: data
  })
}

// 修改预约信息
export function updateInfo(data) {
  return request({
    url: '/hospital/info',
    method: 'put',
    data: data
  })
}

// 删除预约信息
export function delInfo(appointId) {
  return request({
    url: '/hospital/info/' + appointId,
    method: 'delete'
  })
}
