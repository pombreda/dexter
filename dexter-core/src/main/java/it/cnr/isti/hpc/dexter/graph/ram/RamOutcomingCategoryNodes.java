/**
 *  Copyright 2012 Diego Ceccarelli
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package it.cnr.isti.hpc.dexter.graph.ram;

import it.cnr.isti.hpc.dexter.graph.NodeStar;
import it.cnr.isti.hpc.dexter.graph.NodesWriter;
import it.cnr.isti.hpc.dexter.graph.OutcomingNodes;
import it.cnr.isti.hpc.dexter.util.DexterParams;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RamIncomingCategoryNodes allows to keep the outcoming category nodes for each
 * node in a graph directly in main memory.
 * 
 * @author Diego Ceccarelli, diego.ceccarelli@isti.cnr.it created on 05/lug/2012
 */
public class RamOutcomingCategoryNodes extends RamNodes implements
		OutcomingNodes, NodesWriter {

	private static RamOutcomingCategoryNodes instance = null;

	private static final Logger logger = LoggerFactory
			.getLogger(RamOutcomingCategoryNodes.class);

	private static DexterParams params = DexterParams.getInstance();

	private RamOutcomingCategoryNodes() {
		super(params.getGraph("category-category", NodeStar.Direction.OUT));
	}

	public static RamOutcomingCategoryNodes getInstance() {
		if (instance == null) {
			instance = new RamOutcomingCategoryNodes();
			logger.info("Loading ram outcoming category nodes");
		}
		return instance;
	}

	// @Override
	public int[] getOutcoming(int id) {
		return getNeighbours(id);
	}

}
