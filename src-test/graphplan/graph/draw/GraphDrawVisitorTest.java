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
package graphplan.graph.draw;

import graphplan.domain.Operator;
import graphplan.domain.Proposition;
import graphplan.flyweight.OperatorFactory;
import graphplan.flyweight.PropositionFactory;
import graphplan.graph.ActionLevel;
import graphplan.graph.PropositionLevel;
import graphplan.graph.planning.PlanningGraph;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.fail;

public class GraphDrawVisitorTest {
	private static final Logger logger = Logger.getLogger(GraphDrawVisitorTest.class.getName());

	private PlanningGraph planningGraph = null;

	@Before
	public void setUp() throws Exception {
		PropositionLevel initialState = new PropositionLevel();
		Proposition proposition = PropositionFactory.getInstance()
				.getProposition("at(a)");
		initialState.addProposition(proposition);
		Proposition proposition2 = PropositionFactory.getInstance()
				.getProposition("~at(a)");
		initialState.addProposition(proposition2);

		OperatorFactory operatorFactory = OperatorFactory.getInstance();
		Operator operTemplate = operatorFactory.createOperatorTemplate("move(A,B)",
				new String[]{"~at(B)", "at(A)"},
				new String[]{"at(B)", "~at(A)"});

		operatorFactory.addOperatorTemplate(operTemplate);

		planningGraph = new PlanningGraph(initialState);

		ActionLevel actionLevel = new ActionLevel();
		Operator operator = null;
		try {
			operator = OperatorFactory.getInstance().getOperator(
					"move(a,b)");
		} catch (Exception e) {
			fail(e.toString());
		}
		actionLevel.addAction(operator);
		planningGraph.addGraphLevel(actionLevel);
	}

	@Test
	public void testVisitElement() {
		GraphDrawVisitor drawVisitor = null;
		try {
			drawVisitor = new GraphDrawVisitor();
		} catch (Exception e) {
			fail(e.toString());
		}

		this.planningGraph.accept(drawVisitor);
		logger.info(drawVisitor.toString());
	}

}
