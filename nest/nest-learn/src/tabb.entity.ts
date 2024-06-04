import { Entity, Column, PrimaryGeneratedColumn,ManyToOne } from 'typeorm';

import { TabA } from './taba.entity';
@Entity({name:'tabb'})
export class TabB {
  @PrimaryGeneratedColumn()
  id: number;

  @Column()
  nome: string;

  @Column()
  aid: number;

}