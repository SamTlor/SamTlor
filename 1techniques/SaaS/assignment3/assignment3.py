# @app.route('/', methods=['GET', 'POST'])
# def index():
#     name = None
#     form = NameForm()
#     if form.validate_on_submit():
#         name = form.name.data
#         form.name.data = ''
#     return render_template('index.html', form=form, name=name)

from flask import Flask, flash, redirect, render_template, url_for, session
from flask_bootstrap import Bootstrap
from flask_moment import Moment
from flask_wtf import FlaskForm
from wtforms import StringField, SubmitField
from wtforms.validators import DataRequired

app = Flask(__name__)
app.config['SECRET_KEY'] = 'hard to guess string'

bootstrap = Bootstrap(app)
moment = Moment(app)


class NameForm(FlaskForm):
    first_name = StringField('What is your first name?', validators = [DataRequired()])
    last_name = StringField('What is your last name?', validators = [DataRequired()])
    vid = StringField('What is your VID?', validators = [DataRequired()])
    major = StringField('What is your major?', validators = [DataRequired()])
    course_name = StringField('What is the course you want to override?', validators = [DataRequired()])
    crn_course = StringField('What is the CRN of the course Section you wish to be enrolled?', validators = [DataRequired()])
    why = StringField('Why do you want a course overide?', validators = [DataRequired()])
    submit = SubmitField('Submit')

#error handlers redirect to appropriate error.html file
@app.errorhandler(404)
def page_not_found_404(err):
    return render_template('404.html'), 404

@app.errorhandler(500)
def internal_server_error_500(err):
    return render_template('500.html'), 500

# get for rendering the form
# post for submiting the form
@app.route('/', methods=['GET', 'POST'])
def index():
    
    form = NameForm()
    
    #name is the var name forced by flask so i use name even tho i want first_name
    #gets it from session['name'] on line 56 but defualt is 'Stranger'
    name = session.get('name', 'Stranger')
    
    if form.validate_on_submit():
        flash('The course override has been submitted')
        session['name'] = form.first_name.data
        return redirect(url_for('index'))
    
    return render_template('index.html', form = form, name = name)



if __name__ == '__main__':
    app.run(debug=True)