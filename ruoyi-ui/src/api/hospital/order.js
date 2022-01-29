import request from '@/utils/request'

// 查询预约订单列表
export function listOrder(query) {
  return request({
    url: '/hospital/order/list',
    method: 'get',
    params: query
  })
}

// 查询预约订单详细
export function getOrder(orderId) {
  return request({
    url: '/hospital/order/' + orderId,
    method: 'get'
  })
}

// 新增预约订单
export function addOrder(data) {
  return request({
    url: '/hospital/order',
    method: 'post',
    data: data
  })
}

// 修改预约订单
export function updateOrder(data) {
  return request({
    url: '/hospital/order',
    method: 'put',
    data: data
  })
}

// 删除预约订单
export function delOrder(orderId) {
  return request({
    url: '/hospital/order/' + orderId,
    method: 'delete'
  })
}
