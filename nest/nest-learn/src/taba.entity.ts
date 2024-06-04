import { Entity, Column, PrimaryGeneratedColumn,OneToMany, JoinColumn } from 'typeorm';
import { ApiProperty } from '@nestjs/swagger';
import { TabB } from './tabb.entity';

@Entity({name:'taba'})
export class TabA {
  @ApiProperty()
  @PrimaryGeneratedColumn()
  id: number;

  @ApiProperty()
  @Column()
  nome: string;

  //@ApiProperty()
  //@OneToMany(() => TabB, (e)=> e.pai, {cascade:['insert', 'update']})
  //@JoinColumn({name:'pai'})
  //filhos: TabB[];

}