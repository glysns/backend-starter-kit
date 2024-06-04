import { Injectable } from '@nestjs/common';
import { TabA } from './taba.entity';
import { TabARepository } from './taba.repository';
import { TabBRepository } from './tabb.repository';

import { TabB } from './tabb.entity';

@Injectable()
export class TabAService {
  constructor(
    private readonly repository: TabARepository,
    private readonly repositoryB: TabBRepository
  ) {}

  async save(entity: TabA): Promise<void> {
    const a = new TabA();
    const nome = new Date().toISOString();
    a.nome = nome;
    const b = new TabB();
    b.nome = "Filho-" + nome;
    const filhos = [];
    filhos.push (b);
    console.log(a);
    entity = await this.repository.save(a);
    console.log('id gerado foi:' + entity.id);
    for (let i = 0; i < filhos.length; i++) {
         const f =  filhos[i];
         f.aid = entity.id;
         await this.repositoryB.save(f);
    }
  }
}