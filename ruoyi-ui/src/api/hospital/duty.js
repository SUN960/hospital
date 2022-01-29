import request from '@/utils/request'

// 查询值班列表
export function listDuty(query) {
  return request({
    url: '/hospital/duty/list',
    method: 'get',
    params: query
  })
}

// 查询值班详细
export function getDuty(dutyId) {
  return request({
    url: '/hospital/duty/' + dutyId,
    method: 'get'
  })
}

// 新增值班
export function addDuty(data) {
  return request({
    url: '/hospital/duty',
    method: 'post',
    data: data
  })
}

// 修改值班
export function updateDuty(data) {
  return request({
    url: '/hospital/duty',
    method: 'put',
    data: data
  })
}

// 删除值班
export function delDuty(dutyId) {
  return request({
    url: '/hospital/duty/' + dutyId,
    method: 'delete'
  })
}
