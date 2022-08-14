export type ProjectVO = {
  id: string
  userId: number
  name: string
  type: string
  industry: string
  config: string
  logo: string
  cover: string
  pages: string
}

export type ProjectPageReqVO = {
  userId: number
  name: string
  type: string
  industry: string
  config: string
  logo: string
  cover: string
  pages: string
  createTime: date
}

export type ProjectExcelReqVO = {
  userId: number
  name: string
  type: string
  industry: string
  config: string
  logo: string
  cover: string
  pages: string
  createTime: date
}
