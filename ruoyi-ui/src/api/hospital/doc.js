import request from '@/utils/request'

// 查询医生列表
export function listDoc(query) {
  return request({
    url: '/hospital/doc/list',
    method: 'get',
    params: query
  })
}

// 查询医生详细
export function getDoc(docId) {
  return request({
    url: '/hospital/doc/' + docId,
    method: 'get'
  })
}

// 新增医生
export function addDoc(data) {
  return request({
    url: '/hospital/doc',
    method: 'post',
    data: data
  })
}

// 修改医生
export function updateDoc(data) {
  return request({
    url: '/hospital/doc',
    method: 'put',
    data: data
  })
}

// 删除医生
export function delDoc(docId) {
  return request({
    url: '/hospital/doc/' + docId,
    method: 'delete'
  })
}
