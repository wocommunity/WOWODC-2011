package wowodc.dashboard.components;

import webobjectsexamples.businesslogic.movies.common.Movie;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eocontrol.EODataSource;

public class MasterDetail extends WOComponent {
	private EODataSource movieDataSource;
	private Movie selectedMovie;

	public MasterDetail(WOContext context) {
        super(context);
    }

	/**
	 * @return the movieDataSource
	 */
	public EODataSource movieDataSource() {
		if(movieDataSource == null) {
			movieDataSource = new EODatabaseDataSource(session().defaultEditingContext(), "Movie");
		}
		return movieDataSource;
	}

	/**
	 * @return the selectedMovie
	 */
	public Movie selectedMovie() {
		return selectedMovie;
	}

	/**
	 * @param selectedMovie the selectedMovie to set
	 */
	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public WOActionResults movieSelected() {
		return null;
	}
}