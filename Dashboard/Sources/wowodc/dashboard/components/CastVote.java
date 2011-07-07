package wowodc.dashboard.components;

import webobjectsexamples.businesslogic.movies.common.Movie;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class CastVote extends WOComponent {
	private Movie movie;
	private String value;

	public CastVote(WOContext context) {
        super(context);
    }

	public WOActionResults addVote() {
		movie().voting().addVote(Integer.parseInt(value()));
		movie().editingContext().saveChanges();
		return null;
	}

	/**
	 * @return the movie
	 */
	public Movie movie() {
		return movie;
	}

	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * @return the value
	 */
	public String value() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}