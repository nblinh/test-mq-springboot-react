export interface Partner {
  id: number;
  alias: string;
  type: string;
  direction: DirectionEnum;
  application: string;
  processedFlowType: ProcessedFlowTypeEnum;
  description: string
}

export enum DirectionEnum {
  INBOUND = 'INBOUND',
  OUTBOUND = 'OUTBOUND'
}

export enum ProcessedFlowTypeEnum {
  MESSAGE = 'MESSAGE',
  ALERTING = 'ALERTING',
  NOTIFICATION = 'NOTIFICATION'
}
