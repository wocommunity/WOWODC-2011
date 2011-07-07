package wowodc.dashboard.components;

import webobjectsexamples.businesslogic.movies.common.Movie;
import webobjectsexamples.businesslogic.movies.common.MovieRole;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eocontrol.EODataSource;

import er.extensions.eof.ERXEOControlUtilities;

public class MasterDetailDetail extends WOComponent {
	private EODataSource movieDataSource;
	private Movie selectedMovie;
	private EODataSource roleDataSource;
	private MovieRole selectedRole;

	public MasterDetailDetail(WOContext context) {
		super(context);
	}

	/**
	 * @return the movieDataSource
	 */
	public EODataSource movieDataSource() {
		if (movieDataSource == null) {
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
	 * @param selectedMovie
	 *            the selectedMovie to set
	 */
	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public WOActionResults movieSelected() {
		roleDataSource = null;
		selectedRole = null;
		return null;
	}

	/**
	 * @return the roleDataSource
	 */
	public EODataSource roleDataSource() {
		if(roleDataSource == null) {
			roleDataSource = ERXEOControlUtilities.dataSourceForObjectAndKey(selectedMovie, Movie.ROLES_KEY);
		}
		return roleDataSource;
	}

	/**
	 * @return the selectedRole
	 */
	public MovieRole selectedRole() {
		return selectedRole;
	}

	/**
	 * @param selectedRole the selectedRole to set
	 */
	public void setSelectedRole(MovieRole selectedRole) {
		this.selectedRole = selectedRole;
	}

	public WOActionResults roleSelected() {
		return null;
	}
}