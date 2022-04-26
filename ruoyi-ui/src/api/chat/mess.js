import request from '@/utils/request'

// 查询消息列表
export function listMess(query) {
  return request({
    url: '/mess/mess/list',
    method: 'get',
    params: query
  })
}

// 查询消息详细
export function getMess(messId) {
  return request({
    url: '/mess/mess/' + messId,
    method: 'get'
  })
}
export function getUser() {
    return request({
      url: '/mess/mess/allUser',
      method: 'get'
    })
  }

// 新增消息
export function addMess(data) {
  return request({
    url: '/mess/mess',
    method: 'post',
    data: data
  })
}

// 修改消息
export function updateMess(data) {
  return request({
    url: '/mess/mess',
    method: 'put',
    data: data
  })
}

// 删除消息
export function delMess(messId) {
  return request({
    url: '/mess/mess/' + messId,
    method: 'delete'
  })
}
