/***********************************************************************************************************************
 *
 * Copyright (C) 2012 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 **********************************************************************************************************************/

package eu.stratosphere.pact.runtime.iterative.event;

import eu.stratosphere.nephele.event.task.AbstractTaskEvent;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class WorkerDoneEvent extends AbstractTaskEvent {

  private int workerIndex;
  //TODO generalize
  private long aggregate;

  public WorkerDoneEvent() {}

  public WorkerDoneEvent(int workerIndex, long aggregate) {
    this.workerIndex = workerIndex;
    this.aggregate = aggregate;
  }

  public int workerIndex() {
    return workerIndex;
  }

  public long aggregate() {
    return aggregate;
  }

  @Override
  public void write(DataOutput out) throws IOException {
    out.writeInt(workerIndex);
    out.writeLong(aggregate);
  }

  @Override
  public void read(DataInput in) throws IOException {
    workerIndex = in.readInt();
    aggregate = in.readLong();
  }
}
