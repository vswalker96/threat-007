export interface DocumentDetails {
  documentId: string;
  title: string;
  editUrl: string;
  viewUrl: string;
  version: number;
  pageCount: number;
  canEdit: boolean;
  created: Date;
  creatorId: number;
  lastModified: Date;
  lastModifiedUserId: number;
  customAttributes: any[];
  customTags: string[];
  product: string;
  status: string;
  classification: string;
  trashed: any;
  parent: any; 
  owner: {
    id: number;
    type: string;
    name: string;
  };
  }