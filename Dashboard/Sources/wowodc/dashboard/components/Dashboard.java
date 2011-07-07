package wowodc.dashboard.components;

import webobjectsexamples.businesslogic.movies.common.Movie;
import webobjectsexamples.businesslogic.movies.common.Voting;
import webobjectsexamples.businesslogic.rentals.common.Rental;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.eoaccess.EODatabaseDataSource;
import com.webobjects.eocontrol.EODataSource;

import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXQ;

public class Dashboard extends WOComponent {
	private EODataSource movie;
	private EODataSource video;
	private EODataSource voting;
	private EODatabaseDataSource rental;

    public Dashboard(WOContext context) {
        super(context);
    }

	public EODataSource movieDataSource() {
		if (movie == null) {
			movie = new EODatabaseDataSource(session().defaultEditingContext(), Movie.ENTITY_NAME);
		}
		return movie;
	}

	public EODataSource votingDataSource() {
		if (voting == null) {
			voting = new EODatabaseDataSource(session().defaultEditingContext(), Voting.ENTITY_NAME);
		}
		return voting;
	}

	public EODataSource videoDataSource() {
		if (video == null) {
			video = new EODatabaseDataSource(session().defaultEditingContext(), "Video");
		}
		return video;
	}

	public EODataSource rentalsCheckedOut() {
		if (rental == null) {
			ERXFetchSpecification<Rental> fs = new ERXFetchSpecification<Rental>("Rental",
					ERXQ.isNull(Rental.DateReturnedKey), null);
			rental = new EODatabaseDataSource(session().defaultEditingContext(), "Rental");
			rental.setFetchSpecification(fs);
		}
		return rental;
	}
}