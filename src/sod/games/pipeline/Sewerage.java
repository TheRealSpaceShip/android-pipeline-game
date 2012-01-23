package sod.games.pipeline;

import sod.games.pipeline.pipes.Flow;
import sod.games.pipeline.pipes.PipesFactory;
import sod.games.pipeline.pipes.Pipe;

public class Sewerage {
	private Pipe pipes[][];
	private Flow flow;
	
	public Sewerage(int wPipes, int hPipes){
		pipes = new Pipe[wPipes][hPipes];
	}
	public void generateRandomSewerage(){
		for ( Pipe[] pipeRow : pipes ){
			for ( Pipe pipe : pipeRow ){
				pipe = PipesFactory.getInstance().createRandomPipe();
			}
		}
	}
}
