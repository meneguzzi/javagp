/*
 * ---------------------------------------------------------------------------
 * Copyright (C) 2010  Felipe Meneguzzi
 * JavaGP is distributed under LGPL. See file LGPL.txt in this directory.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * To contact the author:
 * http://www.meneguzzi.eu/felipe/contact.html
 * ---------------------------------------------------------------------------
 */
package graphplan.graph.algorithm;

import graphplan.graph.ActionLevel;
import graphplan.graph.PropositionLevel;
import graphplan.graph.planning.PlanningGraphException;

public interface ActionLevelGenerator {
	/**
	 * Creates a new action level to succeed the proposition level specified.
	 * @param propositionLevel The preceding proposition level from which new actions will be generated.
	 * @return A new action level for the graph.
	 * @throws PlanningGraphException
	 */
	public ActionLevel createNextActionLevel(PropositionLevel propositionLevel) throws PlanningGraphException;
}
